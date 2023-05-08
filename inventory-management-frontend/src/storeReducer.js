import { configureStore } from '@reduxjs/toolkit';
import { warehouseApi } from './api/warehouseApi';
import { inventoryApi } from './api/inventoryApi';
import { productApi } from './api/productApi';

//            Create my store using these reducers
const storeReducer = configureStore({
    reducer: {
        // If you just use the variable name
        // It's shorthand for { counter: counter }
        //counter: counterReducer,
        // Instead of choosing the name like above with 'counter' 
        // Whatever the value of storeApi.reducerPath is, that is the name of the property AKA the key
        [warehouseApi.reducerPath]: warehouseApi.reducer,
        [inventoryApi.reducerPath]: inventoryApi.reducer,
        [productApi.reducerPath]: productApi.reducer
    },
    // Middleware is just a function that runs at some point (similar to AOP)
    // Add the storeApi's middleware to the default middleware
    middleware: (defaultMiddleware) => defaultMiddleware().concat(warehouseApi.middleware).concat(inventoryApi.middleware).concat(productApi.middleware)
});

export default storeReducer;