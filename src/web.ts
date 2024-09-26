import { WebPlugin } from '@capacitor/core';
import type { SimInfoPlugin } from './definitions';

export class SimInfoWeb extends WebPlugin implements SimInfoPlugin {
  // Implementa o método getSimInfo para a web
  async getSimInfo(): Promise<{ phoneNumber: string | null }> {
    console.warn('SimInfo is not available on web.');
    return { phoneNumber: null }; // Retorna null já que não é possível acessar o SIM na web
  }
}
