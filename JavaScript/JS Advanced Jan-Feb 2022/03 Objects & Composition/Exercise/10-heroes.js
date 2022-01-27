function heroes() {
    const doCast = (state) => ({
        cast: (spell) => {
            console.log(`${state.name} cast ${spell}`);
            state.mana--;
        }

    })

    const doFight = (state) => ({
        fight: () => {
            console.log(`${state.name} slashes at the foe!`);
            state.stamina--;
        }

    })

    const mage = (name) => {
        let state = {
            name,
            health: 100,
            mana: 100
        }
        return Object.assign(state, doCast(state));
    }

    const fighter = (name) => {
        let state = {
            name,
            health: 100,
            stamina: 100
        }
        return Object.assign(state, doFight(state));
    }

    return { mage: mage, fighter: fighter };
}