import { Button, TextField, Grid, Box  } from '@material-ui/core';
import { useState } from "react";
import React, { Component } from 'react';

/**
 * This component is responsible for rendering a form to create a new warehouse
 * @param {function} handleCreate - A callback function to handle the creation of a new warehouse
 * @returns A JSX element representing the form for creating a new warehouse
 */
export const CreateWarehouse = ({handleCreate}) => {  
    const [showForm, setShowForm] = useState(false);         
    const warehouse = {
        id: Number,
        name: String,
        maxCapacity: Number
    }
    const [inputName, setInputName] = useState(warehouse.name);    
    const [inputCapacity, setInputCapacity] = useState(warehouse.maxCapacity);

     /**
     * Toggles the display of the form
     */
    const showAddForm = () => {
        setShowForm(!showForm);        
    }

     /**
     * Handles the submission of the form
     * @param {object} warehouse - An object representing the warehouse to be created
     */
    function handleSubmit(warehouse){
        handleCreate(warehouse);
    }

    return (
        <>
        <Box className={"formContainer"} display={showForm ? 'block' : 'none'}>
        <Button className={"button"} variant="contained" onClick={showAddForm} >New Warehouse</Button>
            
            {/* Form for creating a new warehouse */}
            <form className={showForm ? "show" : "hide"}>
                    <Grid container spacing={3}>
                        <Grid item xs={12}>
                        <TextField 
                                id="name" 
                                label="Name" 
                                variant="outlined" 
                                fullWidth
                                value={inputName} 
                                onChange={e => setInputName(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <TextField 
                                id="maxCapacity" 
                                label="Max Capacity" 
                                variant="outlined" 
                                fullWidth
                                value={inputCapacity} 
                                onChange={e => setInputCapacity(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <Button 
                                type="submit" 
                                variant="contained" 
                                className={"button"}
                                onClick = {() => {handleSubmit({name:inputName, maxCapacity:Number(inputCapacity)})}}
                            >
                                Submit
                            </Button>
                        </Grid>
                    </Grid>
                </form>
            </Box>
        </>
    )
}