import { ValidatorFn } from "@angular/forms";

export function appEmailValidator(domains: string[]): ValidatorFn {
    // /^[^@]{6,}@gmail\.(com|bg)$/
    const domainStr = domains.join('|');
    const regEx = new RegExp(`^[^@]{6,}@gmail\.(${domainStr})$`)
    return (control) => {
        return (control.value === '' || regEx.test(control.value)) ? null : { appEmailValidator: true }
    }
}