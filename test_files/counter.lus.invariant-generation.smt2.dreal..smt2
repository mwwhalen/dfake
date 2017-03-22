(set-logic QF_NRA )
(assert true )
(declare-fun %init () Bool )
(declare-fun $sum$~1 () Int )
(declare-fun $prop1$~1 () Bool )
(declare-fun $sum$0 () Int )
(declare-fun $prop1$0 () Bool )
(assert (and (= $sum$0 (ite true 1 (+ $sum$~1 1 ) ) ) (= $prop1$0 (< $sum$0 10 ) ) ) )
(assert (not (and false $prop1$0 (not $prop1$0 ) (>= $sum$0 1 ) (<= $sum$0 1 ) ) ) )
(check-sat )
(exit )

; dReal: Solution:
