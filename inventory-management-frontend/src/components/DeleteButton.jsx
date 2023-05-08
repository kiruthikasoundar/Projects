import { useState } from 'react';
import { Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle } from '@mui/material';

export default function DeleteButton(props) {
  // State to control whether the dialog box is open or not
  const [open, setOpen] = useState(false);

  // Function to handle click event of the button to open the dialog box
  const handleClickOpen = () => {
    setOpen(true);
  };

  // Function to handle click event of the Cancel button in the dialog box
  const handleClose = () => {
    setOpen(false);
  };

  // Function to handle click event of the Delete button in the dialog box
  const handleDelete = () => {
    props.onDelete();
    setOpen(false);
  };

  return (
    <>
      {/* Delete button */}
      <Button className="button" variant="contained" onClick={handleClickOpen}>Delete</Button>
      {/* Dialog box */}
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Confirm Deletion</DialogTitle>
        <DialogContent>
          <DialogContentText>Are you sure you want to delete this item?</DialogContentText>
        </DialogContent>
        <DialogActions>
          {/* Cancel button */}
          <Button onClick={handleClose}>Cancel</Button>
          {/* Delete button */}
          <Button onClick={handleDelete} color="error">Delete</Button>
        </DialogActions>
      </Dialog>
    </>
  );
}
