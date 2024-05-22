import { useNavigate } from 'react-router-dom'

function AddEmployee(){

    const navigator = useNavigate()

    function addNewEmployee(){
        navigator('/add-employee')
    }

    return(
        <>
            
            <button className="btn btn-primary mb-2" onClick={ addNewEmployee }>Add Employee</button>
        
        </>
    )
}

export default AddEmployee