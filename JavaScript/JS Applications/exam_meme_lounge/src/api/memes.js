import * as api from './api.js';

const endpoints = {
    memes: '/data/memes?sortBy=_createdOn%20desc',
    create: '/data/memes',
    getById: '/data/memes/',
    delete: '/data/memes/',
    editById: '/data/memes/',
    memesByUserId: (userId) => `/data/memes?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`
};

export async function getAllMemes() {
    return api.get(endpoints.memes);
}

export async function create(data) {
    return api.post(endpoints.create, data);
}

export async function getMemeById(id) {
    return api.get(endpoints.getById + id);
}

export async function deleteMemeById(id) {
    return api.del(endpoints.delete + id);
}

export async function editMemeById(id, data) {
    return api.put(endpoints.editById + id, data);
}

export async function getMemesByUserId(userId) {
    return api.get(endpoints.memesByUserId(userId));
}

