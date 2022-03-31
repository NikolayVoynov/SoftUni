import * as api from './api.js';

const endpoints = {
    theaters: '/data/theaters?sortBy=_createdOn%20desc&distinct=title',
    create: '/data/theaters',
    getById: '/data/theaters/',
    deleteById: '/data/theaters/',
    update: '/data/theaters/',
    theatersByUserId: (userId) => `/data/theaters?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
};

export async function getAll() {
    return api.get(endpoints.theaters);
}

export async function create(data) {
    return api.post(endpoints.create, data);
}

export async function getById(id) {
    return api.get(endpoints.getById + id);
}

export async function deleteById(id) {
    return api.del(endpoints.deleteById + id);
}

export async function update(id, data) {
    return api.put(endpoints.update + id, data);
}

export async function getAllByUserId(userId) {
    return api.get(endpoints.theatersByUserId(userId));
}