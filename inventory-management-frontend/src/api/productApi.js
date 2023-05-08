import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const productApi = createApi ({
    reducerPath: 'productApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
    endpoints: (builder) => ({
        findAllProduct: builder.query({
        query: () => '/products'
        }),
        createProduct: builder.mutation({
        query: (product) => ({
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            url: '/products',          
            body: JSON.stringify(product)
        })
        }),
        updateProduct: builder.mutation({
        query: (product) => ({
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            url: `/products/${product.id}`,
            body: JSON.stringify(product)
        })
        }),
        deleteProductById: builder.mutation({
        query: (id) => ({
            method: 'DELETE',
            url: `/products/${id}`
        })
        }),
        findAllProductByCategoryId: builder.query({
        query: (id) => `/categories/${id}/products`
        })
        })
      });
      
      export const {
        useFindAllProductQuery,
        useCreateProductMutation,
        useUpdateProductMutation,
        useDeleteProductByIdMutation,
        useFindAllProductByCategoryIdQuery
      } = productApi;