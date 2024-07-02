import { WebPlugin } from '@capacitor/core';

import type { SimInfoPlugin } from './definitions';

export class SimInfoWeb extends WebPlugin implements SimInfoPlugin {
  async getSimInfo(): Promise<{ value: string }> {
    console.log('getSimInfo');
    return { value: 'Sim information goes here' }; // ou o valor que você deseja retornar
  }
}
