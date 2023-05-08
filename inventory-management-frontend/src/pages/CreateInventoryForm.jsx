import { useState } from "react";
import { makeStyles } from '@material-ui/core/styles';
import { Button, TextField, FormControl, InputLabel, Select, MenuItem } from '@material-ui/core';
import { useCreateInventoryMutation } from "../api/inventoryApi";
import { useFindAllCategoriesQuery } from '../api/categoryApi';
import { useFindAllProductQuery } from '../api/productApi';

const useStyles = makeStyles((theme) => ({
  formControl: {
    margin: theme.spacing(1),
    minWidth: 120,
  },
}));

export const CreateInventoryForm = ({ handleCreate }) => {
  const classes = useStyles();
  const [quantity, setQuantity] = useState(0);
  const [productId, setProductId] = useState("");
  const [createInventory, { isLoading }] = useCreateInventoryMutation();
  const { data: products } = useFindAllProductQuery();

  const handleProductNameChange = (event) => {
    setProductName(event.target.value);
  };

  const handleQuantityChange = (event) => {
    setQuantity(event.target.value);
  };

  const handleCategoryChange = (event) => {
    setCategoryId(event.target.value);
  };

  const handleProductChange = (event) => {
    setProductId(event.target.value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!productName || !quantity || !categoryId || !productId) {
      return;
    }

    try {
      await createInventory({ productName, quantity, categoryId, productId }).unwrap();
      handleCreate();
      setProductName("");
      setQuantity(0);
      setCategoryId("");
      setProductId("");
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
    <FormControl className={classes.formControl}>
        <InputLabel>Product</InputLabel>
        <Select value={productId} onChange={handleProductChange}>
          {products.map((product) => (
            <MenuItem key={product.id} value={product.id}>
              {product.name}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      <TextField
        label="Quantity"
        type="number"
        value={quantity}
        onChange={handleQuantityChange}
      />
      <FormControl className={classes.formControl}>
        <InputLabel>Category</InputLabel>
        <Select value={categoryId} onChange={handleCategoryChange}>
          {categories.map((category) => (
            <MenuItem key={category.id} value={category.id}>
              {category.name}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
      
      <Button type="submit" variant="contained" color="primary" disabled={isLoading}>
        Add Inventory
      </Button>
    </form>
  );
};

export const CreateInventoryPage = ({ handleCreate }) => {
  

  return (
    <>
      <h3>Create Inventory</h3>
      {categories && products ? (
        <CreateInventoryForm
          handleCreate={handleCreate}
          products={products}
        />
      ) : (
        <div>Loading...</div>
      )}
    </>
  );
};
