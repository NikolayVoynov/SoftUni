class Company {

    departments = {};

    addEmployee(name, salary, position, department) {
        if (name === '' || name === null || name === undefined) {
            throw new Error('Invalid input!')
        } else if (salary === '' || salary === null || salary === undefined || salary < 0) {
            throw new Error('Invalid input!')
        } else if (position === '' || position === null || position === undefined) {
            throw new Error('Invalid input!')
        } else if (department === '' || department === null || department === undefined) {
            throw new Error('Invalid input!')
        }

        if (!this.departments[department]) {
            this.departments[department] = [];
            this.departments[department].push([name, salary, position]);

        } else {
            this.departments[department].push([name, salary, position]);
        }

        return `New employee is hired. Name: ${name}. Position: ${position}`;

        // console.log(`New employee is hired. Name: ${name}. Position: ${position}`);
    }

    bestDepartment() {
        let bestAvgSalary = 0;
        let bestDepartment = '';

        for (const department in this.departments) {

            let deptTotalSalary = 0;

            let numberEmployees = this.departments[department].length;

            for (const employee of this.departments[department]) {
                deptTotalSalary += employee[1];
            }

            let currentAvgSalary = deptTotalSalary / numberEmployees;

            if (currentAvgSalary > bestAvgSalary) {
                bestAvgSalary = currentAvgSalary;
                bestDepartment = department;
            }
        }

        bestAvgSalary = bestAvgSalary.toFixed(2);

        console.log(`Best Department is: ${bestDepartment}`);
        console.log(`Average salary: ${bestAvgSalary}`);

        this.departments[bestDepartment].sort(function (a, b) {
            let result = b[1] - a[1];

            if (result === 0) {
                result = a[0].localeCompare(b[0]);
            }

            return result;
        });

        for (const employee of this.departments[bestDepartment]) {
            console.log(`${employee[0]} ${employee[1]} ${employee[2]}`);
        }

    }

}


let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());

