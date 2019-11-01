/**
 * @(#)RoadTrip.java
 *
 *
 * Ritesh Kanchi
 * Road Trip 1.00 2019/10/29
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class RoadTrip {

	public static void main(String[] args) {
		int friends, totalBudget, carChoice;
		int miles = 900, days = 5, budget = 125;
		double gasCost = 2.53;
		String[] carNames = new String[] {
			"Ford Fiesta",
			"Nissan Juke",
			"Volkswagen Jetta",
			"Mitsubishi Lancer",
			"Chrystler 200",
			"Toyota Camry",
			"Lincoln MKZ",
			"Jeep Grand Cherokee",
			"Toyota FJ Cruiser",
			"Chevy Suburban",
			"Dodge Grand Caravan",
			"Toyota Sequioa"
		};
		int[] carSeats = new int[] {
			2,
			2,
			4,
			4,
			5,
			5,
			5,
			5,
			5,
			7,
			7,
			7
		};
		double[] carFee = new double[] {
			73.72,
			74.78,
			81.32,
			84.21,
			83.72,
			90.15,
			92.34,
			106.48,
			108.52,
			152.33,
			133.17,
			155.55
		};
		int[] carGas = new int[] {
			35,
			31,
			38,
			33,
			35,
			39,
			30,
			25,
			20,
			21,
			26,
			17
		};
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("How many friends are going with you on the road trip? (MAX: 7)");
		friends = scan.nextInt();
		totalBudget = friends * budget;
		System.out.println("Your total budget is $" + totalBudget + "");
		System.out.println("Here are your car options for " + friends + " friend(s):");
		System.out.println(" ");
		System.out.println("COST OF GAS: $" + gasCost + "");
		System.out.println("MILES ROUND TRIP: " + miles + " miles");
		System.out.println(" ");
		System.out.println("\t\tCAR TYPE\t\tSEATS\t\tDAILY RENTAL FEE\t\tGAS MILEAGE");

		if (friends<2) {
			System.out.println("\t1\t" + carNames[0] + "\t\t" + carSeats[0] + "\t\t" + carFee[0] + "\t\t\t\t" + carGas[0] + "mpg");
			System.out.println("\t2\t" + carNames[1] + "\t\t" + carSeats[1] + "\t\t" + carFee[1] + "\t\t\t\t" + carGas[1] + "mpg");
			System.out.println("\t3\t" + carNames[2] + "\t" + carSeats[2] + "\t\t" + carFee[2] + "\t\t\t\t" + carGas[2] + "mpg");
			System.out.println("\t4\t" + carNames[3] + "\t" + carSeats[3] + "\t\t" + carFee[3] + "\t\t\t\t" + carGas[3] + "mpg");
			System.out.println("\t5\t" + carNames[4] + "\t\t" + carSeats[4] + "\t\t" + carFee[4] + "\t\t\t\t" + carGas[4] + "mpg");
			System.out.println("\t6\t" + carNames[5] + "\t\t" + carSeats[5] + "\t\t" + carFee[5] + "\t\t\t\t" + carGas[5] + "mpg");
			System.out.println("\t7\t" + carNames[6] + "\t\t" + carSeats[6] + "\t\t" + carFee[6] + "\t\t\t\t" + carGas[6] + "mpg");
			System.out.println("\t8\t" + carNames[7] + "\t" + carSeats[7] + "\t\t" + carFee[7] + "\t\t\t\t" + carGas[7] + "mpg");
			System.out.println("\t9\t" + carNames[8] + "\t" + carSeats[8] + "\t\t" + carFee[8] + "\t\t\t\t" + carGas[8] + "mpg");
			System.out.println("\t10\t" + carNames[9] + "\t\t" + carSeats[9] + "\t\t" + carFee[9] + "\t\t\t\t" + carGas[9] + "mpg");
			System.out.println("\t11\t" + carNames[10] + "\t" + carSeats[10] + "\t\t" + carFee[10] + "\t\t\t\t" + carGas[10] + "mpg");
			System.out.println("\t12\t" + carNames[11] + "\t\t" + carSeats[11] + "\t\t" + carFee[11] + "\t\t\t\t" + carGas[11] + "mpg");
			System.out.println("\nWhich car do you want?");
			carChoice = scan.nextInt();
			if (carChoice == 1) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[0]) * gasCost;
				double carTotal = carFee[0] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 2) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[1]) * gasCost;
				double carTotal = carFee[1] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 3) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[2]) * gasCost;
				double carTotal = carFee[2] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 4) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[3]) * gasCost;
				double carTotal = carFee[3] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 5) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[4]) * gasCost;
				double carTotal = carFee[4] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 6) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[5]) * gasCost;
				double carTotal = carFee[5] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 7) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[6]) * gasCost;
				double carTotal = carFee[6] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 8) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[7]) * gasCost;
				double carTotal = carFee[7] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 9) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[8]) * gasCost;
				double carTotal = carFee[8] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 10) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[9]) * gasCost;
				double carTotal = carFee[9] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 11) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[10]) * gasCost;
				double carTotal = carFee[10] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 12) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[11]) * gasCost;
				double carTotal = carFee[11] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
		}

		if (friends >= 3 && friends<= 5) {
			System.out.println("\t1\t" + carNames[4] + "\t\t" + carSeats[4] + "\t\t" + carFee[4] + "\t\t\t\t" + carGas[4] + "mpg");
			System.out.println("\t2\t" + carNames[5] + "\t\t" + carSeats[5] + "\t\t" + carFee[5] + "\t\t\t\t" + carGas[5] + "mpg");
			System.out.println("\t3\t" + carNames[6] + "\t\t" + carSeats[6] + "\t\t" + carFee[6] + "\t\t\t\t" + carGas[6] + "mpg");
			System.out.println("\t4\t" + carNames[7] + "\t" + carSeats[7] + "\t\t" + carFee[7] + "\t\t\t\t" + carGas[7] + "mpg");
			System.out.println("\t5\t" + carNames[8] + "\t" + carSeats[8] + "\t\t" + carFee[8] + "\t\t\t\t" + carGas[8] + "mpg");
			System.out.println("\t6\t" + carNames[9] + "\t\t" + carSeats[9] + "\t\t" + carFee[9] + "\t\t\t\t" + carGas[9] + "mpg");
			System.out.println("\t7\t" + carNames[10] + "\t" + carSeats[10] + "\t\t" + carFee[10] + "\t\t\t\t" + carGas[10] + "mpg");
			System.out.println("\t8\t" + carNames[11] + "\t\t" + carSeats[11] + "\t\t" + carFee[11] + "\t\t\t\t" + carGas[11] + "mpg");
			System.out.println("\nWhich car do you want?");
			carChoice = scan.nextInt();
			if (carChoice == 1) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[4]) * gasCost;
				double carTotal = carFee[4] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 2) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[5]) * gasCost;
				double carTotal = carFee[5] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 3) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[6]) * gasCost;
				double carTotal = carFee[6] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 4) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[7]) * gasCost;
				double carTotal = carFee[7] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 5) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[8]) * gasCost;
				double carTotal = carFee[8] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 6) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[9]) * gasCost;
				double carTotal = carFee[9] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 7) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[10]) * gasCost;
				double carTotal = carFee[10] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 8) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[11]) * gasCost;
				double carTotal = carFee[11] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
		}

		if (friends >= 6 && friends<= 7) {
			System.out.println("\t1\t" + carNames[9] + "\t\t" + carSeats[9] + "\t\t" + carFee[9] + "\t\t\t\t" + carGas[9] + "mpg");
			System.out.println("\t2\t" + carNames[10] + "\t" + carSeats[10] + "\t\t" + carFee[10] + "\t\t\t\t" + carGas[10] + "mpg");
			System.out.println("\t3\t" + carNames[11] + "\t\t" + carSeats[11] + "\t\t" + carFee[11] + "\t\t\t\t" + carGas[11] + "mpg");
			System.out.println("\nWhich car do you want?");
			carChoice = scan.nextInt();
			if (carChoice == 1) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[9]) * gasCost;
				double carTotal = carFee[9] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 2) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[10]) * gasCost;
				double carTotal = carFee[10] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}
			if (carChoice == 3) {
				System.out.println("Your total budget is $" + totalBudget);

				double gasTotal = ((double) miles / carGas[11]) * gasCost;
				double carTotal = carFee[11] * days;
				double subtotal = carTotal + gasTotal;
				System.out.println("Your gas cost is $" + df.format(gasTotal));
				System.out.println("Your car cost is $" + df.format(carTotal));
				System.out.println("Your subtotal is $" + df.format(subtotal));
				double finalCost = (double) totalBudget - subtotal;
				if (finalCost > 0) {
					System.out.println("You can afford this, and you will have $" + df.format(finalCost) + " left.");
				} else {
					System.out.println("You can't afford this, and you will be $" + df.format(finalCost) + " in debt.");
				}
			}

		}
	}

}