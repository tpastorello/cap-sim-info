export interface SimInfoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
