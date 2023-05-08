import { useState } from "react";
import { Button, TextField} from '@material-ui/core';

export const WarehousePage = ({warehouse, handleDelete, handleUpdate}) => {

    const [isEdit, setIsEdit] = useState(false);
    const [inputName, setInputName] = useState(warehouse.name);
    const [inputCapacity, setInputCapacity] = useState(warehouse.maxCapacity);    
    
    if (isEdit) {
        return (
            <div className="container">
                <TextField value={inputName} variant="outlined" onChange = {e => setInputName(e.target.value)} />
                <TextField value={inputCapacity} variant="outlined" onChange = {e => setInputCapacity(e.target.value)}/>
                <Button key="update" variant="contained" color="primary" style={{marginLeft: 5 + 'px'}} onClick={() => {
                    handleUpdate({id:warehouse?.id,name:inputName,maxCapacity:Number(inputCapacity)});
                    setIsEdit(false);
                }}>Update</Button>
                <Button key="cancel" variant="contained" style={{marginLeft: 5 + 'px'}} onClick={() => setIsEdit(false)}>Cancel</Button>
            </div>
        );
    }

    return (        
        <div className="container">
            <span>
                <h2 style={{marginRight: 10 + 'px'}}>{warehouse.name}</h2>
                <h3 style={{marginRight: 10 + 'px'}}>{warehouse.maxCapacity}</h3>
                <Button key="edit" variant="contained" style={{marginLeft: 5 + 'px'}} onClick={() => setIsEdit(true)}>Edit</Button>
                <Button key="delete" variant="contained" style={{marginLeft: 5 + 'px'}} onClick={() => handleDelete(warehouse?.id)}>Delete</Button>            
            </span>
        </div>
    );

}