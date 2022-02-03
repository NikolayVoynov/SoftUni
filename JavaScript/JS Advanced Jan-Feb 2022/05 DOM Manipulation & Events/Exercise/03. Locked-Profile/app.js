function lockedProfile() {
    Array.from(document.querySelectorAll('.profile button'))
        .forEach(button => button.addEventListener('click', moreInfo));

    function moreInfo(evnt) {
        let profile = evnt.target.parentElement;
        let isActive = profile.querySelector('input[value="unlock"]').checked;

        if (isActive) {
            let info = Array.from(profile.querySelectorAll('div'))
                .find(p => p.id.includes('HiddenFields'));

            if (evnt.target.textContent === 'Show more') {
                evnt.target.textContent = 'Hide it';
                info.style.display = 'block';
            } else {
                evnt.target.textContent = 'Show more';
                info.style.display = 'none';
            }
        }
    }
}