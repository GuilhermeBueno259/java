package com.softgraf.agendamento;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAgendamento {
	private static boolean tic = true;
	private static int contador = 0;

	public static void main(String[] args) {
		Timer timer = new Timer();
		Timer timerBackup = new Timer();
		
		TimerTask tarefa = new TimerTask() {

			@Override
			public void run() {
				System.out.println( tic ? "Tic..." : "Tac...");
				tic = !tic;
				if (contador++ == 9) {
					timer.cancel();
				}
			}
		};
		
		TimerTask tarefaBackup = new TimerTask() {

			@Override
			public void run() {
				System.out.println("\nFazendo Backup do Sistema");
				timerBackup.cancel();
			}
		};

		// inicia uma tarefa ápos 5 segundos e repete a cada 1 segundo
		timer.schedule(tarefa, 5000, 1000);
		
		Date horario = new Date(System.currentTimeMillis() + 30000);
		System.out.println("O backup iniciará às: " + horario);
		timerBackup.schedule(tarefaBackup, horario);
		
		System.out.println("\nThread main() finalizou");
	}

}
