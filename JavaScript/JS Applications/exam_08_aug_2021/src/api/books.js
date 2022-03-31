import * as api from './api.js';

const endpoints = {
    books: '/data/books?sortBy=_createdOn%20desc',
    bookById: '/data/books/',
    create: '/data/books',
    deleteById: '/data/books/',
    edit: '/data/books/',
    booksByUserId: (userId) => `/data/books?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
};


export async function getAll() {
    return api.get(endpoints.books);
}

export async function getBookById(id) {
    return api.get(endpoints.bookById + id)
}

export async function addBook(data) {
    return api.post(endpoints.create, data)
}

export async function deleteBookById(id) {
    return api.del(endpoints.deleteById + id)
}

export async function editBook(id, data) {
    return api.put(endpoints.edit + id, data)
}

export async function booksByUserId(userId) {
    return api.get(endpoints.booksByUserId(userId))
}