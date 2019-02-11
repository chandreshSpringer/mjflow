import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JflowgatewaySharedModule } from 'app/shared';
import {
    JournalSComponent,
    JournalSDetailComponent,
    JournalSUpdateComponent,
    JournalSDeletePopupComponent,
    JournalSDeleteDialogComponent,
    journalSRoute,
    journalSPopupRoute
} from './';

const ENTITY_STATES = [...journalSRoute, ...journalSPopupRoute];

@NgModule({
    imports: [JflowgatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        JournalSComponent,
        JournalSDetailComponent,
        JournalSUpdateComponent,
        JournalSDeleteDialogComponent,
        JournalSDeletePopupComponent
    ],
    entryComponents: [JournalSComponent, JournalSUpdateComponent, JournalSDeleteDialogComponent, JournalSDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JflowgatewayJournalSModule {}
