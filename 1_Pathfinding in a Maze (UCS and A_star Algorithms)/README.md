>EN
# Pathfinding in a Maze (UCS and A_star Algorithms)

The assignment involves developing a search algorithm for a robot that must navigate through a maze. The maze is represented as an NxN grid, where some cells are free and others contain obstacles that the robot cannot visit. The robot starts from an initial cell and needs to find the closest path to one of two specified goal cells. Each move incurs a movement cost depending on the difference in cell values and the direction of the movement (horizontal, vertical, or diagonal).

The implementation includes two methods:
* **Uniform Cost Search (UCS)**: Finds the cheapest path based on movement cost.
* **A Search* with a heuristic function**: Uses an admissible heuristic to optimize the search.

---
>GR
# Αναζήτηση Διαδρομής σε Λαβύρινθο (UCS και A_star αλγόριθμοι)

Η εργασία αφορά την ανάπτυξη αλγορίθμου αναζήτησης για ένα ρομπότ που πρέπει να βρει το δρόμο του μέσα σε έναν λαβύρινθο. Ο λαβύρινθος αποτελείται από έναν πίνακα ΝxN, όπου ορισμένα κελιά είναι ελεύθερα και άλλα περιέχουν εμπόδια, τα οποία το ρομπότ δεν μπορεί να επισκεφθεί. Το ρομπότ ξεκινά από ένα αρχικό κελί και πρέπει να βρει την πλησιέστερη διαδρομή προς ένα από δύο συγκεκριμένα τελικά κελιά. Για κάθε κίνηση, το κόστος μετακίνησης εξαρτάται από τη διαφορά των τιμών των κελιών και από την κατεύθυνση της μετακίνησης (οριζόντια, κατακόρυφη ή διαγώνια).

Η υλοποίηση περιλαμβάνει δύο μεθόδους:
* **Αναζήτηση ομοιόμορφου κόστους (Uniform Cost Search - UCS)**: Βρίσκει το φθηνότερο μονοπάτι βάσει του κόστους μετακίνησης.
* **Αναζήτηση A* με ευρετική συνάρτηση**: Χρησιμοποιεί μια αποδεκτή ευρετική για να βελτιστοποιήσει την αναζήτηση.
