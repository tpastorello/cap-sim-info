export interface SimInfoPlugin {
  getSimInfo(): Promise<{ phoneNumber: string | null }>;
}
