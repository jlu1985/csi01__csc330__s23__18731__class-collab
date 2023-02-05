# Class Workshop Project

# CSC 330 - Object Oriented Software Design

## Session Information

Spring 2023 Class number 18731

Instructor: Jia Lu <jia.lu@csi.cuny.edu>

## Class Schedules:

-   Tues: 6:30pm -- 9:10pm (2h40m) 3N109

-   Thurs: 6:30pm -- 8:10pm (1h40m) 3N109

## Office hour:

-   Officially: Thurs 8:10 to 9:10 by appointments

    -   3N109 if we can use the same room.

    -   1N113 or library

## Github Repo:

<https://github.com/jlu1985/csi01__csc330__s23__18731__class-collab>

## Mural Documentation:

<https://bit.ly/csc330-s23-pizzeria>

## Description:

We will work on a class project together during lab hours. Each lab is a
workshop that breaks down OO and focuses on a specific topic. The topics
are designed to align with the group project timelines to help you
progress one step at a time. For example, the SDLC workshop is to help
you break down requirements of an idea. The Object-Oriented class
workshop is to model the requirements into objects or classes.

Please save your work from the workshops, we will continue from the same
materials in future workshops.

We will review solutions as a class, and you are encouraged to volunteer
and present your solutions as well.

Class Workshop Project -- Joe\'s Pizzeria

Joe makes the best pizza in town and now in 2023 he wants to open a
pizzeria. He wants to utilize modern technologies to make a more
seamless flow. Joe come to our CSC330 class for an order management
system.

First Joe wants to take customers\' orders using a kiosk, tablet, or
mobile app too instead of traditional pen and paper.

Joe's pizzeria menu, since Joe makes best pizzas, he has a specialty
pizza on the menu along with other traditional ones.

1.  Peperoni (10in --14in)

2.  Plain Cheese (10in- 16in)

3.  Hawaiian (8in-12in)

4.  Joe's specialty (8in-14in) (extra white alfredo, extra cheese,
    chicken)

5.  Customize (8in-16in)

    a.  Sause

        i.  Tomato

        ii. White Alfredo

    b.  Crust

        i.  Thin

        ii. Regular

    c.  Cheese

        i.  Less

        ii. Regular

        iii. Extra

    d.  Toppings

        i.  Peperoni

        ii. Chicken

        iii. Pineapple

### 

Joe is a nice guy, and he wants to help all the hard-working students
that He makes a commitment that his 8in specialty pizza will always be
affordable. And all the pizzas will be priced according to the
following.

Base rate (adjustable based on inflation),

all prices should end with c99 or c49. (2decimal places)

For example, if base rate for Peperoni is \$10,

an 8inch Peperoni should be selling at \$10 \* 1.1 -c1 = \$10.99.

A general formula is round to up half dollar, then subtract one cent.

A 12inch should be selling at \$11 (price of 8ch before -c1) \* 1.4 =
\$15.4 then round up to \$15.49

A slice of Peperoni should is selling at \$15.4 /6 = \$2.57 rounding up
to \$2.75

  -------------------------------------------------------------------------
  Pizza        8in           10       12in     14in     Slice
  ------------ ------------- -------- -------- -------- -------------------
  Peperoni     Base \* 1.1   8in \*   8in \*   8in \*   12in/6 round to
                             1.2      1.4      1.6      Quarter

  Plain Cheese Base (not     8in      8in \*   8in \*   12in/6 to Quarter
               sold)         \*1.2    1.4      1.6      

  Hawaiian     Base \* 1.5   8in \*   8in \*   NA       12in/6 to Quarter
                             1.2      1.4               

  Special      \$4.99        Base 1.2 Base 1.4 Base 1.6 12in/6 to Quarter
  -------------------------------------------------------------------------

  --------------------------------------------------------------------------
  Customized   8in         10          12in         14in         16in
  ------------ ----------- ----------- ------------ ------------ -----------
  Size         Base        1.2         1.4          1.6          1.8

               No Sause    Tomato      White                     
                                       Alfredo                   

  Sause        0           \$0.5       \$0.5                     

  Crust        Thin        Thick       Regular                   

  Crust        0           0           0                         

               Peperoni    Chicken     Pineapple                 

  Toppings     \$0.5       \$0.75      \$0.25                    
  --------------------------------------------------------------------------

  ------------------------------------------------------------------------
  Drinks                   2littred \$3            Can Soda \$1
  ------------------------ ----------------------- -----------------------

  ------------------------------------------------------------------------

### 

Joe wants the kiosk to show order's total when he takes orders, so he
does not have to do calculations in his head.

![Table Description automatically
generated](media/image1.png){width="3.979722222222222in"
height="3.1879451006124233in"}

![Calendar Description automatically
generated](media/image2.png){width="3.6255063429571304in"
height="4.281847112860892in"}

Every night before closing, he wants to click the report button that
shows him today's order rundown and the grand total.

![](media/image3.png){width="4.385416666666667in" height="5.0in"}

Joe wants to take his shop online; The same menu items are available
online. Only a simple webpage is needed. At the beginning the customers
can view the webpage and call the phone number to place an order,
customer will pay in cash when picking up.

When the online business mature, Joe wants to add ordering capabilities
to the website so that the customer can pay with credit cards.

Joe then wants to streamline his pizza flows. He makes certain pizzas
for customers to walk in when they only buy slices. But Joe is too busy
and often forgets to make up the empty ones. He wants the kiosk to send
him a note (alert message) when the counter pizza is almost finished.

For example, he makes two pies of plain cheese, total of (12 slices), he
wants to be reminded when he gets below 4slices (including 4)

*Future requirement (pretend you don't see this one yet), now Joe is
happy when the reminder message, customers always have a good selections
pizza to choose from. But the reminder is getting overwhelming. When
approaching close, Joe constantly gets alerts (all kinds of low stock
pizzas, because it is not necessary to make new ones) Joe wants to
suppress the alert or set an active time range of the reminders.*

Joe wants to work with a delivery service so that customers can order
his pizza online. Here is what Joe has in mind.

-   UberEATS

    -   After signing up UberEATS Joe setups his menu and rate

    -   UberEATS will send Joe a JSON message for orders, but will
        > charge him 20% of every order, Joe needs to reply to the
        > message 'order accepted.'

    -   Then Joe needs to prepare his order and send uber 'order ready'
        > message.

    -   Then an Uber driver will come to pick up the order.

-   Private Delivery Driver (bikes)

    -   Joe wants to take a more economical approach; he knows a local
        > delivery services shop that can also deliver in this
        > neighborhood.

    -   When Joe takes a phone/online order, Joe needs to take the
        > customer's address.

    -   Joe needs to send an 'XML' message to the shop when the order is
        > ready. The message will need to include the customers\' phone
        > number and address. Each delivery is charging \$2 within a
        > 5miles radius.

Joe's also exploring another menu items, he's creating another secret
chicken wing recipes. The selections are the following.

Crispy wings. 5piece, 10piece, 20pieces

Grill wings, 5piece, 10 pieces, 20pieces

prices are set as the following. Configurable base price (Wings) for
5piece wings. 10piece is 190% of 5piece, 20pieces is 180% of 10pieces.

You can choose, regular, mild, and spicy for both types of wings.

Now Joe's selling wings, he's adding combo on the menus.

1\. Pizza, wings and, Soda

example pricing: (Pepperoni (size) + 5piece wings + soda) \* 90%

2\. Double pizza down

example pricing: (total sum of any mix and match pizza 2) \* 85%

3\. Game night party combo

any of the three pizzas, wings, mixed and match (85%)

Updated combo order display.

![A picture containing table Description automatically
generated](media/image4.png){width="3.760941601049869in"
height="3.9901399825021873in"}

The process of order goes like this.

Joe will select the menu item combo1. For example, pizza, wings, soda,
then he will need to punch in a Pizza (size), wing (pieces) and a soda.
Then he will need to complete the order.

(!!Challenge Feature/Logic alert!!)

Now the combos are very popular, almost all customers buy combos all the
time. Joe wants to simplify the ordering process by having combos
priced. Here is the new flow.

(Same pizza combo) Joe selects a pizza (size), wing(pieces), a soda. The
system will automatically make this a combo order and discounts applied.

The pricing selection rule goes like this:

1\. the most discount will apply first.

2\. if discount percentages are the same, (biggest discounted dollars
applied first)

2\. Each item can only be used once in any of the combo

> For example, two pizza, wings, and soda you will get.
>
> 1\. Game Night Party Combo (Not Double Pizza Down)
>
> 2\. Soda

(!!Challenge Feature/Logic!!)

Joe is opening a second store now, but based the location is in another
state. He must make the follow adjustments.

1.  All pizzas are available for all 8inches to 16 inches.

2.  The second store is using a higher base price.

3.  Specialty pizza price is only for locals, so the second store uses
    the regular price model.

4.  Joe wants to see both stores' sales reports via a single terminal
    (console, web, or kiosk)

5.  Each store sells its own combo selections.
