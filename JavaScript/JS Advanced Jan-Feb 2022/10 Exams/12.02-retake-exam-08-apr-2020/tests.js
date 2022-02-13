let { expect } = require('chai');
let { Repository } = require("./solution.js");

describe("Test repository", function () {
    describe("Initialization", function () {
        it("Should add props object as property on initialization", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            expect(repository).to.have.property('props');
            expect(repository.props).to.deep.equal(properties);
        });

        it("Should have property data as Map on initialization", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            expect(repository).to.have.property('data');
            expect(typeof repository.data).is.equal('object');
        });
    });

    describe("Test Get Count", function () {
        it("Should count number of entities", function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            repository.add(entity);
            repository.add(entity);

            expect(repository.count).is.equal(2);
        });

        it("Should return 0 number of entities", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);
            expect(repository.count).is.equal(0);
        });
    });

    describe("Add Entity", function () {
        it("Should return correct id when add entity", function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);
            let returnedId0 = repository.add(entity);
            let returnedId1 = repository.add(entity);

            expect(returnedId0).to.equal(0);
            expect(returnedId1).to.equal(1);
        });

        it("Should store valid entity in data map", function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);
            repository.add(entity);


            expect(repository.data.get(0)).not.to.be.undefined;
            expect(repository.data.get(0)).to.deep.equal(entity);

        });

        it("Should throw error message if property is missing", function () {
            let entity = {
                name: "Pesho",
                age: 22,
            };

            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            expect(() => repository.add(entity)).to.throw(Error, 'Property birthday is missing from the entity!');
        });

        it("Should throw error message if property type is not correct", function () {
            let entity = {
                name: 22,
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            expect(() => repository.add(entity)).to.throw(Error, 'Property name is not of correct type!');
        });
    });

    describe("Test Get Id", function () {
        it("Should throw error if entity with this id do not exist", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let repository = new Repository(properties);

            expect(() => repository.getId(0)).to.throw(Error, 'Entity with id: 0 does not exist!');
        });

        it("Should return entity by id", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let repository = new Repository(properties);
            repository.add(entity);

            expect(repository.getId(0)).to.deep.equal(entity);
        });
    });

    describe("Test Update entity", function () {
        it("Should throw error if entity with this id do not exist", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let newEntity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let repository = new Repository(properties);

            expect(() => repository.update(0, newEntity)).to.throw(Error, 'Entity with id: 0 does not exist!');
        });

        it("Should throw error for missing property when validate new entity", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let newEntity = {
                name: "Pesho",
                age: 22,
            };

            let repository = new Repository(properties);
            repository.add(entity);

            expect(() => repository.update(0, newEntity)).to.throw(Error, 'Property birthday is missing from the entity!');
        });

        it("Should throw error if property type of new entity is not correct", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let newEntity = {
                name: "Pesho",
                age: 22,
                birthday: 22
            };

            let repository = new Repository(properties);
            repository.add(entity);

            expect(() => repository.update(0, newEntity)).to.throw(Error, 'Property birthday is not of correct type!');
        });

        it("Should set new entity after update", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let newEntity = {
                name: "Nikolay",
                age: 30,
                birthday: new Date(1991, 3, 16)
            };

            let repository = new Repository(properties);
            repository.add(entity);
            repository.update(0, newEntity)


            expect(repository.data.get(0)).to.deep.equal(newEntity);
        });
    });


    describe("Test Delete entity by Id", function () {
        it("Should throw error if entity with this id do not exist", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let newEntity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let repository = new Repository(properties);
            repository.add(newEntity)

            expect(() => repository.del(2)).to.throw(Error, 'Entity with id: 2 does not exist!');
        });

        it("Should Delete entity and return true", function () {
            let properties = {
                name: "string",
                age: "number",
                birthday: "object"
            };

            let newEntity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };

            let repository = new Repository(properties);
            repository.add(newEntity);

            let result = repository.data.delete(0);

            expect(result).to.be.true;
        });
    });
});
