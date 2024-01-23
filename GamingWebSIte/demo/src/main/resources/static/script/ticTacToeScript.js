document.addEventListener('DOMContentLoaded', () => {
    const board = document.getElementById('game-board');
    const turnDisplay = document.getElementById('turn-display');
    const restartButton = document.getElementById('restart-button');
    let currentPlayer = 'X';
    const cells = Array.from({ length: 9 });
  
    cells.forEach((_, index) => {
      const cell = document.createElement('div');
      cell.classList.add('cell');
      cell.dataset.index = index;
      cell.addEventListener('click', handleCellClick);
      board.appendChild(cell);
    });
  
    function handleCellClick(event) {
      const clickedCell = event.target;
      const index = clickedCell.dataset.index;
  
      if (!cells[index] && !checkWinner()) {
        cells[index] = currentPlayer;
        clickedCell.textContent = currentPlayer;
        currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
  
        if (checkWinner()) {
          displayWinner(`Player ${currentPlayer === 'X' ? 'O' : 'X'} wins!`);
        } else if (cells.every(cell => cell)) {
          displayWinner('It\'s a draw!');
        }
  
        updateTurnDisplay();
      }
    }
  
    function checkWinner() {
      const winConditions = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6]
      ];
  
      return winConditions.some(condition => {
        const [a, b, c] = condition;
        return cells[a] && cells[a] === cells[b] && cells[a] === cells[c];
      });
    }
  
    function resetGame() {
      cells.fill(null);
      document.querySelectorAll('.cell').forEach(cell => {
        cell.textContent = '';
      });
      currentPlayer = 'X';
      updateTurnDisplay();
    }
  
    function updateTurnDisplay() {
      turnDisplay.textContent = `Player ${currentPlayer}'s Turn`;
    }
  
    function displayWinner(message) {
      const modal = document.getElementById('modal');
      const modalContent = document.getElementById('modal-content');
      const winnerMessage = document.getElementById('winner-message');
      const restartGameButton = document.getElementById('restart-game-button');
  
      winnerMessage.textContent = message;
  
      modal.style.display = 'block';
  
      restartGameButton.addEventListener('click', () => {
        modal.style.display = 'none';
        resetGame();
      });
    }
  
    // Initial turn display
    updateTurnDisplay();
  });
  