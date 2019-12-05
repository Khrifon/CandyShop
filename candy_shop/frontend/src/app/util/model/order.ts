import {Cart} from './cart';

export class Order {
  id: string;
  totalPrice: number;
  creditCardId: string;
  cart: Cart;
}
