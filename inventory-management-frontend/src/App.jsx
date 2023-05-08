import React, { useState } from 'react';
import { useFindAllWarehousesQuery, useCreateWarehouseMutation, useUpdateWarehouseMutation, useDeleteWarehouseMutation } from './api/warehouseApi';
import { CreateWarehouse } from './components/CreateWarehouse';
import './App.css';
import { Button } from '@material-ui/core';
import { Inventory } from './components/Inventory';
import DeleteButton from './components/DeleteButton';

function App () {  
  const { data: warehouses, error, isLoading, refetch } = useFindAllWarehousesQuery();    
  const [createWarehouse] = useCreateWarehouseMutation();
  const [updateWarehouse] = useUpdateWarehouseMutation();
  const [deleteWarehouse] = useDeleteWarehouseMutation();
  const [data, setData] = useState(warehouses);  
  const [editIndex, setEditIndex] = useState(-1);  
  const [showInventory, setShowInventory] = useState(false); 
  const [warehouseId, setWarehouseId] = useState();       
  const isBackClicked = (data) => {
    if (data){
      setShowInventory(!showInventory);    
    }    
  }

  const handleEdit = (index) => {
    setEditIndex(index);
  };

  const handleSave = (index, newData) => {
    setData(warehouses.map((row, i) => (i === index ? newData : row)));
    setEditIndex(-1);
    updateWarehouse(newData)
      .unwrap()
      .then(() => refetch());
  };

  const handleDelete = (index) => {
    setData(warehouses.filter((row, i) => i !== index));
      deleteWarehouse(warehouses[index].id)
        .unwrap()
        .then(() => refetch());
  };

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  } 

  function handleCreate(warehouse) {        
    createWarehouse(warehouse)
      .unwrap()
      .then(() => refetch());
  }

  const handleView = (index) => {
    setData(warehouses.filter((row, i) => i !== index));    
    setWarehouseId(warehouses[index].id);    
    setShowInventory(!showInventory);
  };

  const TableRow = ({ row, index, isEditing, onEdit, onSave, onDelete, onView }) => {
    const [name, setName] = useState(row.name);
    const [maxCapacity, setMaxCapacity] = useState(row.maxCapacity);
    
    const handleEditClick = () => {
      onEdit(index);
    };
    
    const handleSaveClick = () => {
      onSave(index, { ...row, name, maxCapacity });
    };
    
    const handleDeleteClick = () => {
      onDelete(index);
    };

    const handleViewClick = () => {      
      onView(index);
    }

    
    return (
      <tr>
        <td>{isEditing ? <input value={name} onChange={(e) => setName(e.target.value)} /> : name}</td>
        <td>{isEditing ? <input value={maxCapacity} onChange={(e) => setMaxCapacity(e.target.value)} /> : maxCapacity}</td>
        <td>{row.currentCapacity}</td>
        <td>{row.currentCapacity/row.maxCapacity*100}%</td>
        <td>
          {isEditing ? (
            <Button className="button" variant="contained" onClick={handleSaveClick}>Save</Button>
          ) : (
            <>
              <Button className="button" variant="contained" onClick={handleViewClick}>View Inventory</Button>
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
      <h2>StockViz</h2>
      
      <div className="container">
        <div className={showInventory ? "hide" : "show"}>
          <table className="table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Max Capacity</th>
                <th>Current Capacity</th>
                <th>Storage %</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {warehouses.map((row, index) => (
                <TableRow
                  key={row.id}
                  row={row}
                  index={index}
                  isEditing={editIndex === index}
                  onEdit={handleEdit}
                  onSave={handleSave}
                  onDelete={handleDelete}
                  onView={handleView}
                />
              ))}
            </tbody>
          </table>
        </div>

        <div className={showInventory ? "hide" : "show"}>
          <CreateWarehouse handleCreate={handleCreate}/>        
        </div>        

        <div className={showInventory ? "show" : "hide"}>
          <Inventory warehouseId={warehouseId} backClick={isBackClicked}/>
        </div>
      </div>
    </>
  );
};

export default App;