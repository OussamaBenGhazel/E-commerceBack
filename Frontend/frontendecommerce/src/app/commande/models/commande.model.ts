export class Commande {
    id?: number;
    orderNumber: string;
    orderDate: string;
    totalAmount: number;
  
    constructor(orderNumber: string, orderDate: string, totalAmount: number, id?: number) {
      this.id = id;
      this.orderNumber = orderNumber;
      this.orderDate = orderDate;
      this.totalAmount = totalAmount;
    }
  }
  