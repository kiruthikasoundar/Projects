import { Button, Box, Grid, TextField, FormControl, InputLabel, Select, MenuItem } from '@material-ui/core';
import { useState } from "react";
import React, { Component } from 'react';
import { useFindAllInventoryQuery, useFindAllInventoryByWarehouseIdQuery, useCreateInventoryMutation, useUpdateInventoryMutation, useDeleteInventoryMutation } from '../api/inventoryApi';
import { useFindAllProductQuery } from '../api/productApi';
import DeleteButton from '../components/DeleteButton';

export const Inventory = (props) => {      
    const { data: inventories, refetch} = useFindAllInventoryByWarehouseIdQuery(props.warehouseId);
    const [createInventory] = useCreateInventoryMutation();
    const [updateInventory] = useUpdateInventoryMutation();
    const [deleteInventory] = useDeleteInventoryMutation();
    const { data: allProducts } = useFindAllProductQuery();    
    const [data, setData] = useState(inventories);
    const [showAddInventory, setShowAddInventory] = useState(false);
    const [productId, setProductId] = useState();
    const [editIndex, setEditIndex] = useState(-1);

    const inventory = {
        warehouseId: Number,
        productId: Number,
        quantity: Number
    };
    const [inputQuantity, setInputQuantity ] = useState(inventory.quantity);

    const addInventory = () => {
        setShowAddInventory(!showAddInventory);        
    };   

    function handleBackClick() {        
        props.backClick(true);
    }

    const handleProductChange = (event) => {
        setProductId(event.target.value);
    };

    function handleSaveInventory() {
        createInventory({warehouseId:props.warehouseId, productId:productId, quantity:inputQuantity})
        .unwrap()
        .then(() => refetch());
    }

    const handleEdit = (index) => {
        setEditIndex(index);
    };

    const handleSave = (index, newData) => {
        setData(inventories.map((row, i) => (i === index ? newData : row)));
        setEditIndex(-1);
        updateInventory(newData)
          .unwrap()
          .then(() => refetch());
    };

    const handleDelete = (index) => {
        setData(inventories.filter((row, i) => i !== index));
        deleteInventory(inventories[index].id)
            .unwrap()
            .then(() => refetch());
      };

    const TableRow = ({ row, index, isEditing, onEdit, onSave, onDelete, onView }) => {        
        const [quantity, setQuantity] = useState(row.quantity);
        
        const handleEditClick = () => {
          onEdit(index);
        };
        
        const handleSaveClick = () => {
          onSave(index, { ...row, quantity });
        };
        
        const handleDeleteClick = () => {
          onDelete(index);
        };    
        
        return (
          <tr>
            <td>{row.productName}</td>
            <td>{isEditing ? <input value={quantity} onChange={(e) => setQuantity(e.target.value)} /> : quantity}</td>            
            <td>
              {isEditing ? (
                <Button className="button" variant="contained" onClick={handleSaveClick}>Save</Button>
              ) : (
                <>                  
                  <Button className="button" variant="contained" onClick={handleEditClick}>Edit</Button>
                  <DeleteButton onDelete={handleDeleteClick} />
                </>
              )}
            </td>
          </tr>
        );
      };

    return (
        <>  
        <Button className="button" variant="contained" onClick={handleBackClick}>Back</Button>    

        {/* Inventory table */}
        <table className="table">
            <thead>
              <tr>
                <th>Product</th>
                <th>Quantity</th>                
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {inventories && inventories.map((row, index) => (
                <TableRow
                  key={row.id}
                  row={row}
                  index={index}
                  isEditing={editIndex === index}
                  onEdit={handleEdit}
                  onSave={handleSave}
                  onDelete={handleDelete}                  
                />
              ))}
            </tbody>
          </table>

        
        <Box className={"formContainer"} display={showAddInventory ? 'block' : 'none'}>
        <Button className={"button"} variant="contained" onClick={addInventory} >Add Inventory</Button>
                <form className={showAddInventory ? "show" : "hide"}>
                    <Grid container spacing={3}>
                        <Grid item xs={12}>
                        <TextField 
                                id="quantity" 
                                label="Quantity" 
                                variant="outlined" 
                                fullWidth
                                value={inputQuantity} 
                                onChange={e => setInputQuantity(e.target.value)}
                            />
                        </Grid>
                        <Grid item xs={12}>
                            <FormControl>
                                <InputLabel>Product</InputLabel>                                
                                <Select value={productId} onChange={handleProductChange}>
                                    {allProducts && allProducts.map((product) => (
                                        <MenuItem key={product.id} value={product.id} label={product.name}>{product.name} </MenuItem>
                                    ))}
                                </Select>
                            </FormControl>
                        </Grid>
                         <Grid item xs={12}>
                            <Button 
                                type="submit" 
                                variant="contained" 
                                className={"button"}
                                onClick = {() => {handleSaveInventory()}}
                            >
                                Save
                            </Button>
                        </Grid>
                    </Grid>
                </form>
            </Box>      
    </>
  );
};