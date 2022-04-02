import * as api from './api.js';

const endpoints = {
    getAll: '/data/cars?sortBy=_createdOn%20desc',
    create: '/data/cars',
    getById: '/data/cars/',
    deleteById: '/data/cars/',
    editById: '/data/cars/',
    getCarsByUserId: (userId) => `/data/cars?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
};

export async function getAllCars() {
    return api.get(endpoints.getAll);
}

export async function create(data) {
    return api.post(endpoints.create, data);
}

export async function getCarById(id) {
    return api.get(endpoints.getById + id);
}

export async function deleteById(id) {
    return api.del(endpoints.deleteById + id);
}

export async function editCarById(id, data) {
    return api.put(endpoints.editById + id, data);
}

export async function getAllCarsByUser(userId) {
    return api.get(endpoints.getCarsByUserId(userId));
}

