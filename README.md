RB BurgerShop Simulator

In diesem Repository ist der Code einer Praktikumsaufgabe, welche 
im Rahmen des Moduls Rechnernetze und Betriebssysteme gestellt wurde.

Sie haben die IT Abteilung des Unternehmens übernommen und, neben der Aushilfe,  einen Spezialisten für Hardware und Betriebssysteme eingestellt.  
 
Der nächste Schritt wird die Einstellung eines Softwareentwicklers (SE) sein.  
Um mit dem SE zukünftige Projekte zu besprechen,  
beteiligte Komponenten zu benennen und  
Abläufe identifizieren zu können,   wollen sie Ihr Businessmodel mit Java darstellen (Graphik ist keine Bedingung/Einfache  Textausgaben reichen/Das Java#Programm sollte außerhalb der IDE über ein Bash# Script gestartet werden können). 
 
                                                    
Das Kerngeschäft ihres Unternehmens ist der Verkauf von Burger,  Verkauf und Produktion ist in den folgenden Punkten beschrieben:   
1. Maximal 20 Kunden können gleichzeitig den Verkaufsraum betreten. Wenn der  Verkaufsraum voll ist, müssen die Kunden leider weiter gehen. Es bildet sich  keine Schlange vor dem Lokal. Abgewiesene Kunden sind kumulativ zu  protokollieren.  Um den Kundenfluss zu simulieren, entwickeln Sie eine Klasse Kundengenerator,  die für einen anzugebenen Zeitraum (zum Beispiel 30s) zufällig 1 bis 5 Kunden  generiert.   
2. Die Kunden werden auf zwei Warteschlangen aufgeteilt, mit dem Ziel, dass beide  Warteschlangen ähnlich lang sind.  Die Länge der Warteschlange sollte auch über  die Zeit protokoliert werden. 
3. Beide Warteschlangen werden von je einer Service#Kraft bedient, welche vom  Kunden die Bestellung annimmt.  Auch hier sollte die Anzahl der angenommenen  Bestellungen protokolliert werden.  Hat eine Service#Kraft mehr als drei Kunden  weniger bedient, hat sie Priorität bei der Bedienung der Kunden. Die Annahme  der Bestellung dauert zufällig zwischen 10 und 5 Sekunden. Ein Kunde bestellt  zufällig verteilt zwischen 1 und 8 Burger. Die Bestellungen werden  an die Küche  weitergeleitet und nach Einreichungszeitpunkt abgearbeitet.  
4. In der Küche arbeiten 3 Hilfskräfte, jede Hilfskraft braucht  zufällig verteilt  zwischen 10  und 20 Sekunden für die Fertigstellung eines Burger. 
5. Die Burger werden nach Fertigstellung auf ein Lieferband gelegt. Die Burger  können aber nur sequentiell auf dieses Lieferband platziert werden, da nicht  genug Platz für zwei Teller nebeneinander vorhanden ist.  Weiter können die  Service#Kräfte die Burger nur in der Folge entnehmen, wie die Burger auf das  Lieferband gestellt worden sind (Queue).   
6. Auf dem Laufband können (maximal) 12 Burger platziert sein.  Firmenpolitik ist,  dass nie mehr als 5 Burger ohne Bestellung auf dem Lieferband vorgehalten  werden dürfen, auch wenn immer mindestens 2 Burger ohne Kundenbestellung,   bereitzustellen sind.  
7. Eine Auslieferung an den Kunden kann nur bei vollständiger Bestellung erfolgen.   Die Auswahl welcher Kunde zuerst bedient wird, wird nach dem  SRTN Verfahren  getroffen: Der Kunde mit der kleinsten Bestellung wird zuerst bedient. Dies hat  das Ziel mehr Kunden den Zugang zum Lokal zu erlauben.  
8. Kein Kunde darf aber länger als ein zu definierendes Maximum warten. Wird  dieses Maximum überschritten, wird dann erst der wartende Kunde mit Priorität  bedient. 
9. Der Kunde zahlt erst, wenn er die Ware vollständig sieht. Die Service#Kraft  übergibt die Burger erst, wenn der Kunde bezahlt hat. Nach dem Erhalt der Ware  braucht der Kunde weitere 10 bis 20  Sekunden (zufällig) bis er das Lokal  verlassen hat.     
10. Zu den Kunden soll weiter die maximal, die minimale und die durchschnittliche  Verweilzeit im Lokal erfasst werden. 
 
Es sollte im ersten Schritt ein UML Diagramm erstellt werden, dass die  Verantwortlichkeiten deutlich macht. Zu schützende Bereiche sind zu identifizieren. Auf  „Aktives Warten“ ist zu verzichten.  
Weiter braucht die Personalabteilung noch fünf Fragen zum Thema Nebenläufigkeit, um  bei einem Telefoninterview eine Filterung der Kandidaten vorzunehmen.   Für die Abgabe gelten die bekannten Rahmenbedingungen.
