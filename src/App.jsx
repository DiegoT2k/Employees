import './App.css'
import ListEmployee from './components/ListEmployee'
import Navbar from './components/Navbar'
import FormEmployee from './components/FormEmployee'
import { BrowserRouter, Routes, Route } from 'react-router-dom'


function App() {

  return (
    <>
  
    <BrowserRouter>
      <Navbar />
        <Routes>
          {/** http://localhost:3000 */}
          <Route path='/' element={ <ListEmployee /> }></Route>

          {/** http://localhost:3000/employees */}
          <Route path='/employees' element={ <ListEmployee /> }></Route>

          {/** http://localhost:3000/add-employee */}
          <Route path='/add-employee' element={ <FormEmployee /> }></Route>

          {/** http://localhost:3000/edit-employee/1 */}
          <Route path='/edit-employee/:id' element={ <FormEmployee /> }></Route>
        </Routes>

    </BrowserRouter>
    
    </>
  )
}

export default App
