import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const warehouseApi = createApi({
    reducerPath: 'warehouseApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
    endpoints: (builder) => ({
      findAllWarehouses: builder.query({
        query: () => '/warehouses'
      }),
      findWarehouseById: builder.query({
        query: (id) => `/warehouses/${id}`
      }),
      createWarehouse: builder.mutation({
        query: (warehouse) => ({
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          url: '/warehouses',          
          body: JSON.stringify(warehouse)
        })
      }),
      updateWarehouse: builder.mutation({
        query: (warehouse) => ({
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          url: `/warehouses/${warehouse.id}`,
          body: JSON.stringify(warehouse)
        })
      }),
      deleteWarehouse: builder.mutation({
        query: (id) => ({
          method: 'DELETE',
          url: `/warehouses/${id}`
        })
      })
    })
  });
  
  export const {
    useFindAllWarehousesQuery,
    //useFindWarehouseByIdQuery,
    useCreateWarehouseMutation,
    useUpdateWarehouseMutation,
    useDeleteWarehouseMutation
  } = warehouseApi;
  