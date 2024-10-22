### vinteum.com
# cap-sim-info

Get SIM Card Info.
For Capacitor.

# npm:
https://www.npmjs.com/package/cap-sim-info

## Install

```bash
npm install cap-sim-info
npx cap sync
```

## Android Manifest 

```xml
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

## API

<docgen-index>

* [`getSimInfo()`](#getsiminfo)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### Sample:

```typescript
import { SimInfo } from 'cap-sim-info';

const info = await SimInfo.getSimInfo();

console.log(info);
```

### getSimInfo()

```typescript
getSimInfo() => Promise<{ phoneNumber: string | null; }>
```

**Returns:** <code>Promise&lt;{ phoneNumber: string | null; }&gt;</code>

--------------------

</docgen-api>
