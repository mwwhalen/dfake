(set-logic QF_NRA )
(assert true )
(declare-fun is-power-of-two () Bool )
(declare-fun a () Int )
(assert (> a 0 ) )
(check-sat )

; dReal: Solution:
; dReal: a : [ ENTIRE ] = [0, inf]
; dReal: is-power-of-two : Bool = undef
; dReal: null
