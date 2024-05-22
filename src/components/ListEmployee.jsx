import React, {useEffect, useState} from "react"
import { deleteEmployee, listEmployee } from "../services/EmployeeService"
import AddEmployee from "./AddEmployee"
import { useNavigate } from "react-router-dom"

function ListEmployee(){

    const navigator = useNavigate()
    const [employees, setEmployees] = useState([])

    useEffect(() => {
        getAllEmployees()
    }, [])


    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    const deleteObj = (id) => { 
        deleteEmployee(id).then(() => {
            //getAllEmployees()
            const newEmployees = employees.filter(employee => employee.id !== id)
            setEmployees(newEmployees)
            
        }).catch(error => {
            console.log(error)
        })
    }

    function getAllEmployees(){
        listEmployee().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })        
    }

    return(
        <>

        <div className="container">

            <h2 className="text-center mt-4">List of employees</h2>
            <AddEmployee />                
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th className="text-center">#1</th>
                        <th className="text-center">#2</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map(value => 
                            <tr key={value.id}>
                                <td>{value.id}</td>
                                <td>{value.firstName}</td>
                                <td>{value.lastName}</td>
                                <td>{value.email}</td>
                                <td className="text-center">
                                    <button className="btn btn-info" onClick={ () => updateEmployee(value.id) }>Update</button>
                                </td>
                                <td className="text-center">
                                    <button className="btn btn-danger" onClick={ () => deleteObj(value.id) }>Delete</button>
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </div>

        </>
    )

}

export default ListEmployee