import { NgModule } from '@angular/core';

import { JflowgatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [JflowgatewaySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [JflowgatewaySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class JflowgatewaySharedCommonModule {}
