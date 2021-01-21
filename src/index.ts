// import { NativeModules } from 'react-native';

// type AnalyticsTestType = {
//   multiply(a: number, b: number): Promise<number>;
// };

// const { AnalyticsTest } = NativeModules;

// export default AnalyticsTest as AnalyticsTestType;
import { Analytics } from './analytics'

export default new Analytics.Client()
export { Analytics }
export { Configuration, JsonMap } from './bridge'
