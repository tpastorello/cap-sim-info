import { registerPlugin } from '@capacitor/core';
import type { SimInfoPlugin } from './definitions';

const SimInfo = registerPlugin<SimInfoPlugin>('SimInfo', {
  web: () => import('./web').then((m) => new m.SimInfoWeb()), 
});

export * from './definitions';
export { SimInfo };
