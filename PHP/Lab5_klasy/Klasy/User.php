<?php


class User
{
    const STATUS_USER=1;
    const STATUS_ADMIN=2;
    protected $userName;
    protected $passwd;
    protected $fullName;
    protected $email;
    protected $date;

    function __construct($username, $passw, $full_name, $e_mail){
            $this->status=User::STATUS_USER;
            $this->userName=$username;
            $this->passwd=password_hash($passw,PASSWORD_BCRYPT);
            $this->fullName=$full_name;
            $this->email=$e_mail;
            $this->date= (new DateTime())->format('Y-m-d');
    }

    function show(){
        echo 'Status: '.$this->status.'</br>';
        echo 'Nazwa użytkownika: '.$this->userName.'</br>';
        echo 'Hasło: '.$this->passwd.'</br>';
        echo 'Imię i nazwiskp: '.$this->fullName.'</br>';
        echo 'E-mail: '.$this->email.'</br>';
        echo 'Data dołączenia: '.$this->date.'</br>';
        echo '</br>';
    }

    /**
     * @return mixed
     */
    public function getUserName()
    {
        return $this->userName;
    }

    /**
     * @param mixed $userName
     */
    public function setUserName($userName)
    {
        $this->userName = $userName;
    }

    /**
     * @return mixed
     */
    public function getpasswd()
    {
        return $this->passwd;
    }

    /**
     * @param mixed $passwd
     */
    public function setpasswd($passwd)
    {
        $this->passwd = passwd_hash($passwd, passwd_BCRYPT);
    }

    /**
     * @return mixed
     */
    public function getfullName()
    {
        return $this->fullName;
    }

    /**
     * @param mixed $fullName
     */
    public function setfullName($fullName)
    {
        $this->fullName = $fullName;
    }

    /**
     * @return mixed
     */
    public function getEmail()
    {
        return $this->email;
    }

    /**
     * @param mixed $email
     */
    public function setEmail($email)
    {
        $this->email = $email;
    }

    /**
     * @return DateTime|string
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @param DateTime $date
     */
    public function setDate($date)
    {
        $this->date = $date;
    }

    /**
     * @return int
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * @param int $status
     */
    public function setStatus($status)
    {
        $this->status = $status;
    }


    static function getAllUsers($file){
        $all_users = json_decode(file_get_contents($file));
        foreach($all_users as $val){
            echo "<p> Nazwa użytkownika: ".$val->userName."</br> Imię i nazwisko:".$val->fullName."</br> Dołączył dnia: ".$val->date."</br> </p>";
        }
}

    function toArray(){
        $arr=[
            'userName' => $this->userName,
            'passwd' => $this->passwd,
            'fullName' => $this->fullName,
            'email' => $this->email,
            'date' => $this->date,
            'status' => $this->status
        ];

        return $arr;
    }

    function save($file){
        $arr = json_decode(file_get_contents($file), true);
        array_push($arr, $this->toArray());
        file_put_contents($file, json_encode($arr));
    }

    public function dodajdoBD($bd){
        $insert = "INSERT INTO users (userName, fullName, email, passwd, status, date) 
                    VALUES ('".$this->userName."', '".$this->fullName."', '".$this->email."', '".  $this->passwd."', '".$this->status."','". $this->date."')";
        $bd->insert($insert);
    }

}