function cityRecord(name, population, treasury) {
    const city = {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += population * this.taxRate;
        },
        applyGrowth(percentage) {
            this.population *= 1 + percentage / 100;
        },
        applyRecession(percentage) {
            this.treasury *= 1 - percentage / 100;
        }
    }

    return city;
}

