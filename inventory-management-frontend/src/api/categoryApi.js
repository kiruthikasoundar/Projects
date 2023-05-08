import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const categoryApi = createApi({
    reducerPath: 'categoryApi',
    baseQuery: fetchBaseQuery({ baseUrl: 'http://localhost:8080/' }),
    endpoints: (builder) => ({
        findAllCategories: builder.query({
        query: () => '/categories'
      }),
      findCategoryById: builder.query({
        query: (id) => `/categories/${id}`
      }),
      createCategopry: builder.mutation({
        query: (category) => ({
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          url: '/categories',          
          body: JSON.stringify(category)
        })
      }),
      updateCategory: builder.mutation({
        query: (category) => ({
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          url: `/categories/${category.id}`,
          body: JSON.stringify(category)
        })
      }),
      deleteCategory: builder.mutation({
        query: (id) => ({
          method: 'DELETE',
          url: `/categories/${id}`
        })
      })
    })
  });
  
  export const {
    useFindAllCategoriesQuery,
    //useFindCategoryByIdQuery,
    useCreateCategopryMutation,
    useUpdateCategoryMutation,
    useDeleteCategoryMutation
  } = categoryApi;
  