export interface SimInfoPlugin {
  getSimInfo(): Promise<{ value: string }>;
}
