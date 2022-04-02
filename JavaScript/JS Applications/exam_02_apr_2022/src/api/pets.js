import * as api from './api.js';

const endpoints = {
    pets: '/data/pets?sortBy=_createdOn%20desc&distinct=name',
    create: '/data/pets',
    getPetById: '/data/pets/',
    update: '/data/pets/',
    delete: '/data/pets/'
};

export async function getAllPets() {
    return api.get(endpoints.pets);
}

export async function createPet(data) {
    return api.post(endpoints.create, data);
}

export async function getById(petId) {
    return api.get(endpoints.getPetById + petId);
}

export async function update(petId, data) {
    return api.put(endpoints.update + petId, data);
}

export async function deleteById(petId) {
    return api.del(endpoints.delete + petId);
}