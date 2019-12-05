import {Shipment} from './shipment';

export class Cart {
  id: string;
  shipments: Shipment[];
  currentPrice: number;
  userId: string;
}
