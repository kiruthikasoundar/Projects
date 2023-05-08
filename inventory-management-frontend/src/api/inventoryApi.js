import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const inventoryApi = createApi ({
    reducerPath: 'inventoryApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
    endpoints: (builder) => ({
        findAllInventory: builder.query({
        query: () => '/inventory'
        }),
        createInventory: builder.mutation({
        query: (inventory) => ({
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            url: '/inventory',          
            body: JSON.stringify(inventory)
        })
        }),
        updateInventory: builder.mutation({
        query: (inventory) => ({
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            url: `/inventory/${inventory.id}`,
            body: JSON.stringify(inventory)
        })
        }),
        deleteInventory: builder.mutation({
        query: (id) => ({
            method: 'DELETE',
            url: `/inventory/${id}`
        })
        }),
        findAllInventoryByWarehouseId: builder.query({
        query: (id) => `/warehouses/${id}/inventory`
        })
        })
      });
      
      export const {
        useFindAllInventoryQuery,
        useCreateInventoryMutation,
        useUpdateInventoryMutation,
        useDeleteInventoryMutation,
        useFindAllInventoryByWarehouseIdQuery
      } = inventoryApi;