import axios from 'axios';
import React, { useState } from 'react'
import { Link,useNavigate } from 'react-router-dom';

function Adduser() {

    let navigate=useNavigate()


    const [user, setuser] = useState({
        name: "",
        username: "",
        email: ""
    });


    const {
        name, username, email } = user


    const onInputChange = (e) => {
        setuser({ ...user, [e.target.name]: e.target.value })
    };


    const onSubmit = async(e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/user",user)
        navigate("/")

    };
    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'> Register User</h2>
                    <form onSubmit={(e)=>onSubmit(e)}>
                        <div className='mb-3'>
                            <label htmlfor="Name" className='form-lable'>Name</label>
                            <input type={"text"} className='form-control' placeholder='Enter your Name' name="name" id="" value={name} onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className='mb-3'>
                            <label htmlfor="UserName" className='form-lable'>User Name</label>
                            <input type={"text"} className='form-control' placeholder='Enter your User Name' name="username" id="" value={username} onChange={(e) => onInputChange(e)} />
                        </div>
                        <div className='mb-3'>
                            <label htmlfor="Email" className='form-lable'>Email</label>
                            <input type={"text"} className='form-control' placeholder='Enter your Email' name="email" id="" value={email} onChange={(e) => onInputChange(e)} />
                        </div>
                        <button type="submit" className='btn btn-outline-primary'>Submit</button>
                        <Link className='btn btn-outline-danger mx-2' to="/">Cancel</Link>
                    </form>
                </div>
            </div>
        </div >
    )
}

export default Adduser