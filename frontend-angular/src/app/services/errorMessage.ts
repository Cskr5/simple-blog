import {FormGroup} from "@angular/forms";
import {HttpErrorResponse, HttpResponse} from "@angular/common/http";

export function handleValidationErrors(error, form: FormGroup) {

    if (error instanceof HttpErrorResponse && error.status === 400) {
        for (const validationError of error.error.fieldErrors) {
            let i = 0;
            const formControl = form.get(validationError.field);
            if (formControl) {
                formControl.setErrors({serverError: validationError.message});
            }
        }
    }
}
