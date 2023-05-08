import { configureStore } from '@reduxjs/toolkit';
import { inventoryApi } from '../api/inventoryApi';

const inventory = configureStore({
    reducer: {
        [inventoryApi.reducerPath]: inventoryApi.reducer
    },
    middleware: (defaultMiddleware) => defaultMiddleware().concat(inventoryApi.middleware)
});

export default inventory;