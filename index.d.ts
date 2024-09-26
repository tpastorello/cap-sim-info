declare module '@capacitor/core' {
    interface PluginRegistry {
        SimInfo: SimInfoPlugin;
    }
}

export interface SimInfoPlugin {
    getSimInfo(): Promise<{ phoneNumber: string | null }>;
}
