import { WebPlugin } from '@capacitor/core';

import type { SimInfoPlugin } from './definitions';

export class SimInfoWeb extends WebPlugin implements SimInfoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
