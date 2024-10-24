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

* [`getSimInfo()`](#getsiminfo)

### Sample:

```typescript
import { SimInfo } from 'cap-sim-info';

const sims = await SimInfo.getSimInfo();

console.log(sims);
```

### getSimInfo()

```typescript
getSimInfo() => Promise<{ phoneNumber: string | null; }>
```

## Returns:
```json
{
    "simInfo": [
        {
            "carrierName": "VIVO",
            "displayName": "VIVO",
            "countryIso": "br",
            "iccId": "895510953571576",
            "simSlotIndex": 0,
            "phoneNumber": "+5546999XXXXXX"
        },
        {
            "carrierName": "Vinteum Telecom",
            "displayName": "Vinteum Telecom",
            "countryIso": "usa",
            "iccId": "895506474390",
            "simSlotIndex": 1,
            "phoneNumber": "+14912813"
        }
    ]
}
```